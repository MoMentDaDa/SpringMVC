package Spring1.Utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 用于记录日志的工具类，它里面提供了公共的代码
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {
    @Pointcut("execution(* Spring1.Service.Impl.*.*(..))")
    private void pt1() {
    }
    // 前置通知
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }
    // 后置通知
    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    // 异常通知
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }
    // 最终通知
    @After("pt1()")
    public void finallyPrintLog() {
        System.out.println("最终通知Logger类中的finallyPrintLog方法开始记录日志了。。。");
        System.out.println("---------------------------");
    }

    // 环绕通知
    //@Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            // 得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            this.beforePrintLog();
            // 明确调用业务层方法（切入点方法）
            rtValue = pjp.proceed(args);
            this.afterReturningPrintLog();
            return rtValue;
        } catch (Throwable t) {
            this.afterThrowingPrintLog();
            throw new RuntimeException(t);
        } finally {
            this.finallyPrintLog();
        }
    }
}
