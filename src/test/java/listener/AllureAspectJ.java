package listener;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static io.qameta.allure.util.AspectUtils.getParametersMap;
import static io.qameta.allure.util.NamingUtils.processNameTemplate;

@Aspect
public class AllureAspectJ {
    private static Logger log = LogManager.getLogger(AllureAspectJ.class);

    @Before("@annotation(io.qameta.allure.Step) && execution(* *(..))")
    public void beforeStep(JoinPoint joinPoint) {
        String stepName = getStepName(joinPoint);
        log.info("BEGIN: " + stepName);
    }

    private String getStepName(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Map<String, Object> parametersMap = getParametersMap(joinPoint);
        Method method = methodSignature.getMethod();
        Step step = method.getAnnotation(Step.class);
        String stepName = step.value();

        return Optional.of(stepName)
                .filter(StringUtils::isNoneEmpty)
                .map(it -> processNameTemplate(it, parametersMap))
                .orElse(methodSignature.getName());
    }

    @AfterReturning(
            pointcut = "@annotation(io.qameta.allure.Step) && execution(* *(..))",
            returning = "result"
    )
    public void afterStep(JoinPoint joinPoint, Object result) {
        String stepName = getStepName(joinPoint);
        log.info("END: " + stepName);
        if(result != null) {
            log.info("RESULT: " + result);
        }
    }
}
