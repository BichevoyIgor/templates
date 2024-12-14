С чего начать:
1.	Подключаем зависимости hibernate-core, postgresql, закидываем  конфиг в resources
2.	Создаем класс сущность с конструктором без параметров и полем Id
3.	Вставляем аннотации @Entity, @Table(name = "data.users"), @Id, @GeneratedValue(strategy = GenerationType.IDENTITY), @Column(name=”…”)
4.	        EntityManagerFactory emFactory =  new Configuration()
                   .configure("hibernate.cfg.xml")
                   .addAnnotatedClass(...class)
                   .addAnnotatedClass(...class)
                   .buildSessionFactory();
           EntityManager em = emFactory.createEntityManager();
           em.getTransaction().begin();
           ...
           em.getTransaction().commit();
           em.close();