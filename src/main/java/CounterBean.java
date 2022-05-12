import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class CounterBean {
    private AtomicInteger counter = new AtomicInteger();

    public int get() {
        System.out.println("Test 3");
        return counter.get();

    }

    @Scheduled(every = "5s")
    void increment() {
        counter.incrementAndGet();
        System.out.println("Test 1");
    }

    @Scheduled(cron = "10 * * * * ?")
    void cronJob(ScheduledExecution execution) {
        counter.incrementAndGet();
        System.out.println("Test 5");
        System.out.println(execution.getScheduledFireTime());
    }


}
