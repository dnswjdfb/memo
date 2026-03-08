package kr.hs.after.memo.Controller;

import kr.hs.after.memo.dto.memoDTO;
import kr.hs.after.memo.dto.memoDTO2;
import kr.hs.after.memo.service.memoService;
import kr.hs.after.memo.service.memoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class memoController {
    @Autowired
    private memoService service;
    @Autowired
    private memoService2 service2;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup_form")
    public String singup_form() {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(memoDTO dto) {
        service.insert(dto);
        return "redirect:/";
    }

    @GetMapping("/write")
    public String login_form() {
        return "login";
    }

    @PostMapping("/write")
    public String write(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        memoDTO dto = service.loginSelect(id);
        if (dto != null) {
            if (dto.getPw().equals(pw)) {
                System.out.println("로그인 성공");
                return "write_form";
            } else {
                System.out.println("로그인 실패");
                return "login";
            }
        }
        return "login";
    }

    @GetMapping("/write_form")
    public String write_form() {
        return "write_form";
    }

    @PostMapping("/wr")
    public String wr(memoDTO2 dto, Model model) {
        service2.insertMemo(dto);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<memoDTO2> dto = service2.select();
        model.addAttribute("dto", dto);
        System.out.println(dto);
        return "list";
    }

    @GetMapping("/delete/{idx}")
    public String delete_form(@PathVariable("idx") int idx, Model model) {
        model.addAttribute("idx", idx);
        return "delete_form";
    }

    @PostMapping("/delete")
    public String delete(memoDTO2 dto, @RequestParam("pw") String pw,@RequestParam("idx") int idx, @RequestParam("id") String id) {
        dto = service2.selectId(id);
        if (dto != null) {
            if (dto.getPw().equals(pw)) {
                service2.delete(idx);
                System.out.println("삭제성공");
                return "redirect:/list";
            }
        } else {
            System.out.println("id없음");
            return "delete_form";
        }
        return "delete_form";
    }
    @GetMapping("/update/{idx}")
    public String update_form(@PathVariable("idx") int idx,Model model){
        model.addAttribute("idx",idx);
        return "update_form";
    }
    @PostMapping("/update")
    public String update(@RequestParam("idx") int idx,@RequestParam("id") String id,@RequestParam("pw") String pw,memoDTO2 dto,Model model){
        System.out.println("idx:"+idx);
        model.addAttribute("dto",dto);
        dto = service2.selectId(id);
        if (dto != null){
            if(dto.getPw().equals(pw)){
                model.addAttribute("idx",idx);
                System.out.println("update_로 이동");
                return "update";
            }
            else{
                System.out.println("실패");
                return "update_form";
            }
        }
        else{
            return "update_form";
        }
    }
    @PostMapping("/update_done")
    public String update_done(memoDTO2 dto ,@RequestParam("idx") int idx){
        System.out.println("idx"+idx);
               service2.update(dto);
        return "redirect:/list"     ;
    }
}

