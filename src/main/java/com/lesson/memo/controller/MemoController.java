package com.lesson.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lesson.memo.repository.MemoRepository;

@Controller
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    // 【/memo/new】にアクセスしたら、メモ作成画面を表示する機能を記述してください
    // @GetMapping("-----")
    // 関数名はshowForm
    // public String -----(-----) {
    //     // モデルにmemoを追加する記述を記述してください
    //     // テンプレートはmemo-form.htmlを使用してください
    //     return "-----";
    // }

    // 【/memo/create】にアクセスしたら、メモを作成する機能を記述してください
    // @PostMapping("-----")
    // 関数名はcreate
    // public String -----("-----")(-----,
    //         -----) {
    //     // バリデーションエラーをチェックする機能の記述
    //     // メモを保存する機能の記述
    //     // 【/memo/new】にリダイレクトする記述
    //     return "redirect:-----";
    // }

}