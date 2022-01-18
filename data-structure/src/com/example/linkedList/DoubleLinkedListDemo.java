package com.example.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改节点
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.list();

        // 删除节点
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表");
        doubleLinkedList.list();

        // 按顺序添加节点
        System.out.println("按顺序添加节点");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.list();



    }
}

class DoubleLinkedList {
    private HeroNode2 headNode = new HeroNode2(0, "", "");


    public void update(HeroNode2 newHeroNode) {
        // 判断是否空
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }

        // 根据heroNo找到需要修改的节点
        HeroNode2 temp = headNode.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (null == temp) { // 已遍历完链表
                break;
            }

            if (temp.heroNo == newHeroNode.heroNo) { // 找到要修改的节点
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号为%d的节点\n", newHeroNode.heroNo);
        }
    }

    /**
     * 双向链表新增节点
     * @param heroNode2
     */
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = headNode;
        while (true) {
            if (null == temp.next) { // 已到链表最后
                break;
            }

            // 没有到链表尾，temp后移
            temp = temp.next;
        }

        // 当退出while循环时，temp就指向了链表的最后
        // 形成了一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    /**
     * 按排名编号顺序添加新节点
     * 找到添加位置的前一个节点
     * @param heroNode2
     */
    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = headNode;
        boolean flag = false; // 标记排名编号是否已存在
        while (true) {
            if (null == temp.next)
                break;

            if (temp.next.heroNo > heroNode2.heroNo) {
                break;
            } else if (temp.heroNo == heroNode2.heroNo){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            System.out.println("待添加的节点编号已存在");
        } else {
            heroNode2.next = temp.next;
            temp.next.pre = heroNode2;
            temp.next = heroNode2;
        }
    }

    /**
     * 遍历双向链表
     */
    public void list() {
        // 判断链表是否为空
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }

        // 头节点不能动，创建辅助链表遍历
        HeroNode2 temp = headNode.next;
        while (true) {
            if (null == temp) { // 链表到最后
                break;
            }
            // 输出节点信息
            System.out.println(temp);

            // 将temp后移
            temp = temp.next;
        }
    }

    /**
     * 根据排名编号删除节点
     * 对于双向链表，可以直接找到要删除的这个节点
     * @param deleteHeroNo 排名编号
     */
    public void delete(int deleteHeroNo) {
        // 判断当前链表是否为空
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp= headNode.next;
        boolean flag = false; // 标志是否找到待删除节点
        while (true) {
            if (null == temp) { // 已经到链表最后
                break;
            }

            if (temp.heroNo == deleteHeroNo) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) { // 找到待删除节点
            temp.pre.next = temp.next;
            // 如果是最后一个节点就不需要执行
            if (null != temp.next)
            temp.next.pre = temp.pre;
        } else {
            System.out.printf("要删除的%d节点不存在\n", deleteHeroNo);
        }
    }
}

class HeroNode2 {
    public int heroNo;
    public String name;
    public String nickName;
    public HeroNode2 next; // 指向下一个节点，默认为null
    public HeroNode2 pre; // 指向前一个节点，默认为null

    public HeroNode2(int heroNo, String name, String nickName) {
        this.heroNo = heroNo;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "heroNo=" + heroNo +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
