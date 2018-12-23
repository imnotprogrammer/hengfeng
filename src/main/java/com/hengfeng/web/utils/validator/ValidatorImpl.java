package com.hengfeng.web.utils.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorImpl implements InitializingBean {
    private Validator validator;
    @Override
    public void afterPropertiesSet() throws Exception {
        //将hibernate validator
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ValidtorResult validate(Object bean)
    {
        ValidtorResult vr = new ValidtorResult();
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0) {
            vr.setHasError(true);
            constraintViolationSet.forEach(constraintViolation->{
                String errMsg = constraintViolation.getMessage();
                String errField = constraintViolation.getPropertyPath().toString();
                vr.getErrMessageMap().put(errField, errMsg);
            });
        }
        return vr;
    }
}
