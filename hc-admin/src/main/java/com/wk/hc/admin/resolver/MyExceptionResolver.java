package com.wk.hc.admin.resolver;

import com.wk.hc.common.exception.MyException;
import com.wk.hc.common.exception.NoLoginException;
import com.wk.hc.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionResolver {


    @ExceptionHandler(NoLoginException.class)
    public ResponseEntity t1(NoLoginException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity t1(MyException e) {
        e.printStackTrace();
        ResultVO vo = new ResultVO();
        vo.setCode(-1);
        vo.setMsg(e.getMsg());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(vo);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity t2(Exception e) {
        e.printStackTrace();
        ResultVO vo = new ResultVO();
        vo.setCode(-1);
        vo.setMsg("服务器内部处理错误,请稍后再试");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(vo);

    }
}
