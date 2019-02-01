package ru.titov.taskmanagerserver.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ServiceMethodInterceptor {

    @AroundInvoke
    public Object logServiceMethod(final InvocationContext context) throws Exception {
        System.out.println("Class: " + context.getMethod().getDeclaringClass().getSimpleName() +
                " Method: " + context.getMethod().getName());
        return context.proceed();
    }

}
