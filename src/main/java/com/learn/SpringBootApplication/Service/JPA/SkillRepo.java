package com.learn.SpringBootApplication.Service.JPA;

import com.learn.SpringBootApplication.Bean.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skill,Integer> {
}
