package com.cpn.fileuploadcpn.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "config", schema = "public")
public class ConfigEntity {

    @Id
    @Column(name = "config_key", nullable = false, length = 50)
    private String configKey;

    @Column(name = "config_value", length = 100)
    private String configValue;

    @Column(name = "status")
    private String status;

    @Column(name = "create_by", length = 32)
    private String createBy;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "update_by", length = 32)
    private String updateBy;

    @Column(name = "update_date")
    private Timestamp updateDate;


}
