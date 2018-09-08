package com.ahea.nurikabe.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Integer> {

	Member findByUserId(String userId);
	Member findByUserIdAndUserPassword(String userId, String userPassword);

}
