package com.lesson.memo.controller;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lesson.memo.model.Memo;
import com.lesson.memo.repository.MemoRepository;

@Controller
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    @GetMapping
    public String list(Model model) {
        List<Memo> memos = memoRepository.findAll();
        model.addAttribute("memos", memos);
        return "memo-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("memo", new Memo());
        return "memo-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid Memo memo,
            BindingResult result) {
        if (result.hasErrors()) {
            return "memo-form";
        }

        memo.setCreatedAt(LocalDateTime.now());
        memo.setUpdatedAt(LocalDateTime.now());
        memoRepository.save(memo);
        return "redirect:/memo";
    }

    // 【/memo/detail/{id}】にアクセスしたら、メモ詳細画面を表示する機能を記述してください
    // @GetMapping("-----")
    // 関数名はshowDetail
    // public String -----(-----, -----) { 
    //     // メモを取得する記述を記述してください。変数名はmemoとしてください。
    //     // メモがない場合はnot-found画面にHTTPステータスを404にして、リダイレクトする記述を記述してください。
    //     // メモをモデルに追加する記述を記述してください。変数名はmemoとしてください。
    //     // テンプレートはmemo-detail.htmlを使用してください。
    //     return "-----";
    // }

    // 【/memo/edit/{id}】にアクセスしたら、メモ編集画面を表示する機能を記述してください
    // @GetMapping("-----")
    // 関数名はshowEditForm
    // public String -----(-----, -----) { 
    //     // update処理でリダイレクトされた時に、直前の入力内容が保持される取得する記述をしてください。
    //     // メモを取得する記述を記述してください。変数名はmemoとしてください。
    //     // メモがない場合はnot-found画面にHTTPステータスを404にして、リダイレクトする記述を記述してください。
    //     // メモをモデルに追加する記述を記述してください。変数名はmemoとしてください。
    //     // テンプレートはmemo-form.htmlを使用してください。
    //     return "-----";
    // }

    // 【/memo/update/{id}】にアクセスしたら、メモを更新する機能を記述してください
    // @PostMapping("/update/{id}")
    // 関数名はupdate
    // public String -----(-----, -----) { 
    //     // メモがない場合はnot-found画面にHTTPステータスを404にして、リダイレクトする記述を記述してください。
    //     // バリデーションエラーが発生した場合、入力内容を保持した状態で、編集画面にリダイレクトするように記述してください。
    //     // メモを更新する記述を記述してください。
    //     // メモ詳細画面にリダイレクトする記述を記述してください。
    //     return "redirect:-----";
    // }
}