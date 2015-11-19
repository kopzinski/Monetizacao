package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, Long> id;
	public static volatile ListAttribute<Conta, Lancamento> lancamentos;
	public static volatile SingularAttribute<Conta, Double> saldo;
	public static volatile SingularAttribute<Conta, String> numero;

}

