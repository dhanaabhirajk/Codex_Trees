package com.codextrees.web.models;

import javax.persistence.*;


@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleType name;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public RoleType getName() {
		return name;
	}
	public void setName(RoleType name) {
		this.name = name;
	}
}