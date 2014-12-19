import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by fanyou-yufei on 14-12-19.
 */
public class StopwatchCPU {
    private final ThreadMXBean threadTimer;
    private final long start;
    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    public StopwatchCPU(){
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    public double elapsedTime(){
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start)/NANOSECONDS_PER_SECOND;
    }
}
