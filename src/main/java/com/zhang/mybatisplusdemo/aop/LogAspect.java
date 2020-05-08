package com.zhang.mybatisplusdemo.aop;

import com.alibaba.fastjson.JSONObject;
import com.zhang.mybatisplusdemo.exception.CommonException;
import com.zhang.mybatisplusdemo.pojo.OperationLog;
import com.zhang.mybatisplusdemo.response.Result;
import com.zhang.mybatisplusdemo.response.ResultCode;
import com.zhang.mybatisplusdemo.service.OperationLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/08/12:22
 * @Description:
 */
@Component
@Aspect
public class LogAspect {

    private  static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private final OperationLogService operationLogService;

    public LogAspect(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    /**
     * 环绕通知所有controller层的所有方法并且方法上要有 @RequestMapping 注解
     *
     * @param pjp            目标方法
     * @param requestMapping 请求注解
     * @return Object
     * @throws Throwable Throwable
     */
    @Around("execution(* com.zhang.mybatisplusdemo.controller.*.*(..)) && @annotation(requestMapping) ")
    public Object insertLogAround(ProceedingJoinPoint pjp, RequestMapping requestMapping) throws Throwable {
        logger.info(" ****** 记录日志 [start] :" + new Date() + " ****** ");

        OperationLog op = new OperationLog();

    /*  , HttpServletRequest request
    String remoteAddr = request.getRemoteAddr();
        op.setRemoteAddr(remoteAddr);*/

        //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        op.setOperateTime(new Date());

        //从Session中获取当前登录用户,这里使用了默认值替换
        op.setOperateUserId(1L);


        op.setOperateClass(pjp.getTarget().getClass().getName());
        op.setOperateMethod(pjp.getSignature().getName());

        //切点执行需要的参数
        Object[] args = pjp.getArgs();
        op.setParamAndValue(Arrays.toString(args));


        long startTime = System.currentTimeMillis();

        //开始执行目标方法
        Object object = null;
        try {
            object = pjp.proceed();
            op.setOperatorResult("true");
            return object;
        } catch (Exception exception) {
            op.setOperatorResult("false");
            logger.error("执行"+op.getOperateClass()+"下的"+op.getOperateMethod()+"方法时出现异常");
            if(exception instanceof CommonException){
                object = new Result(501, exception.getMessage());
            }else{
                object = new Result(ResultCode.SYS_ERROR);
            }
            return object;
        } finally {
            long endTime = System.currentTimeMillis();
            op.setCostTime(endTime - startTime);
            assert object != null;
            op.setReturnClass(object.getClass().getName());
            op.setReturnValue(object.toString());

            operationLogService.add(op);
            logger.info(" ******* 记录日志结束 [end]  ****** ");
        }
    }
}
