package ar.edu.unq.desapp.grupoA.aspects;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LoggerAspect {

    private Logger log = Logger.getLogger(getClass());

    //busca todos los metodos publicos del paquete XX y que tengan la annotacion Loggeable
    //@After("execution(public * ar.edu.unq.desapp.grupoA.services.*.*(..)) && @annotation(Loggable)")
    @After("execution(public * ar.edu.unq.desapp.grupoA.services.*.*(..))")
    public void logAfter(JoinPoint pjp) {
        log.info(pjp.getSignature().getName() + " called...TESTING");
    }

}
