package com.objectprovider;
//Author :- Onkar B. Madhekar //
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.bean.Account;
import com.bean.UserClass;

public class SessionProvider {

	// Session Object Provider
	public static Session getSession() {

		Configuration config = new Configuration().configure().addAnnotatedClass(Account.class)
				.addAnnotatedClass(UserClass.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		return session;

	}

}
//Author :- Onkar B. Madhekar //