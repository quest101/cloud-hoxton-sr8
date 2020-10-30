package con.ken.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRibbonConfig {

    /**
     * RoundRobinRule：轮询
     * RandomRule：随机
     * AvailabilityFilteringRule：会先过滤由于多次访问故障处于断路器跳闸状态 的服务，还有并发的连接数据超过阈值的服务，然后对剩余的服务列表按照轮询策略进行选取
     * WeightedResponseTimeRule：根据平均响应时间计算所有服务的权重,响应时间越快权重越大，刚启动时如果统计信息不足,则使用RoundRobinRule策略，等统计信息足够时后,会切换到WeightedResponseTieRule
     * RetryRule：先按照RoundRobinRule的策略获取服务，如果获取服务失败,则在制定时间内会重试,再获取不到, 则放弃
     * BestAvailableRule：会先过滤掉由于多次访问故障,而处于断路器跳闸的服务，然后选择一个并发量最小的服务
     * ZoneAvoidanceRule：默认规则,符合判断Server所在区域的性能和server的可用性选择服务器
     *
     * @return
     */
    @Bean
    public IRule user() {
        return new RoundRobinRule();
    }
}
