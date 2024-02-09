package com.app.fe;

import com.app.fe.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommunityRepository extends JpaRepository<Community, Long> {
}
