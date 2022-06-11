package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    /*
    MemberRepository 인터페이스에 대한 객체만 있음
    Memory든  JDBC든 다형성으로 인해 모두 들어올 수 있음.
    추상화에 의존하게 되어 DIP 원칙 지킴
    -> 성성자 주입
     */
    private final MemberRepository memberRepository ;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
