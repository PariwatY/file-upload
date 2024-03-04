package com.cpn.fileuploadcpn.repository;

import com.cpn.fileuploadcpn.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, String> {

}
