package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*
    어떠한 상황에서 각 상황에서 쓰일 객체를
    AppConfig에서 생성 & 할당 해주는 작업이 분리되어 수행한다.

    본래 MemberService에서 생성하던 Repository도 분리하여
    AppConfig에서 생성하게됨.
     */
//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository(); // 어떤 Repo를 쓸지 여기만 수정해주면됨.
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        /*
        return new FixDiscountPolicy(); // 어떤 할인정책을 쓸지 여기만 바꿔주면 됨
         */
        return new RateDiscountPolicy();

    }
}
