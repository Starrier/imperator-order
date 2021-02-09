package org.starrier.imperator.order.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * @author starrier
 * @date 2021/2/3
 */
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDO implements Serializable {

    private static final long serialVersionUID = -558043294043707772L;
    @Id
    private String userId;
    private String nickName;
    private String phoneNumber;
    private Integer gender;
}
