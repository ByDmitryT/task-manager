package ru.titov.taskmanagerserver.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@ServiceTime
@Interceptor
public class ServiceTimeInterceptor {

    @AroundInvoke
    public Object logServiceTime(final InvocationContext context) throws Exception {
        final long start = System.currentTimeMillis();
        final Object object = context.proceed();
        final long end = System.currentTimeMillis();
        final long time = end - start;
        System.out.println("time: " + time);
        return object;
    }

}
