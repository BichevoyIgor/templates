**AOP – Aspect Oriented Programming**<br>
AOP – технология для отделения бизнес логики приложения, от служебной(логирование, проверка прав…)<br>
Для задействования данной технологии необходимо:
1. прописываем зависимость на spring-boot-starter-aop, 
2. над конфиг классом ставится @EnableAspectJAutoProxy
3. создается отдельный прокси класс, в котором создаются методы которые будут срабатывать в определенный момент времени<br>
   @Component<br>
   @Aspect<br>
   public class ____Aspect {<br>
   ..@Before(“execution(public void getBook())”)<br>
   .....public void methodAdvice(){<br>
   ........     //логика<br>
   .....}<br>
   ..}

@Before(“execution(метод())”) – метод аспекта сработает перед выполнением заданного метода<br>
@AfterReturning – выполнится после нормального окончания метода<br>
@AfterThrowing – выполнится после окончания метода только если было выброшено исключение<br>
@After/ After finally – выполнится после окончания метода<br>
@Around – выполнится ДО и ПОСЛЕ окончания метода<br>

Pointcut – выражение описывающее где должен быть применен Advice<br>
Синтаксис pointcut expression:<br>
execution( ~~modifier~~ **returnType** ~~classPath~~ **methodName(params)** ~~throws~~ ) – **обязательные**(2) и ~~не обязательные~~(3) элементы Pointcut<br>
`*` можно заменить член выражения или названия метода<br>

  ("execution(public void ru.bichevoy.Book.getBook())") // сработает для конкретного метода класса<br>
  ("execution(* ru.bichevoy.Book.*())") // сработает для любого метода класса Book<br>
  ("execution(public void getBook())") // будет срабатывать для любого public void getBook()<br>
  ("execution(public void get*())") // сработает для любого public void get метода<br>
  ("execution(* get*())") // сработает для любого get метода<br>
  ("execution(* get*(*))") // сработает для любого get метода c 1 параметром любого типа<br>
  ("execution(* get*(String))") // сработает для любого get метода c 1 параметром String типа<br>
  ("execution(* get*(..))") // сработает для любого get метода c любым кол-вом параметров любого типа<br>
  ("execution(* *(..))") // сработает для любого метода c любым кол-вом параметров любого типа<br>

Создание именованного pointcut, имя которого можно потом использовать за место expression или удобного комбинирования через ||  &&  !

    @Pointcut("execution(public void set*(..))") // создание pointcut
    private void allSetMethodsFromBook(){
    }

