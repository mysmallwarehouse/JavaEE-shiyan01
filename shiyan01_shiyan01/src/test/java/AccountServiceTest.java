import com.qst.bean.Account;
import com.qst.service.AccountService;


import com.qst.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class AccountServiceTest {
    /**
     * 使用Junit单元测试，测试我们的配置
     */


    @Test
    public void testFindAll() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setUname("test");
        account.setBalance(12);

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdata() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setBalance(22222);
        as.updateAccount(account);

    }

    @Test
    public void testDelete() {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法
        as.deleteAccount(5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入转出账户：");
        String out2 = sc.nextLine();
        System.out.println("请输入转入账户：");
        String in2 = sc.nextLine();
        System.out.println("请输入金额：");
        int balance2  = sc.nextInt();
        sc.close();

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //3.执行方法

        as.transfer(out2,in2,balance2);
        System.out.println("转账成功");
    }

    }











