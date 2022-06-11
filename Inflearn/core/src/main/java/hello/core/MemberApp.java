package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    // "psvm" 이라고 치면 자동 완선
    // "p"ublic "s"tatic "v"oid "m"ain ....
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        /*
        DIP를 준수하여 AppConfig에서 생성& 할당된 객체로 해당 Service 작업 수행
         */


        /*
        Spring 사용하기
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */
        // Configuration 어노테이션으로 등록된 AppConfig 안에 Bean 어노테이션으로 설정되어 있는 class 들
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 메서드 이름으로 Bean 가져옴
        // 두번째 인수는 Type
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("fing member = " + findMember.getName());
    }
}
