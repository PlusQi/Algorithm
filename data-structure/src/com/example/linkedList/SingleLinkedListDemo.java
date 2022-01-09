package com.example.linkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

/*        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.update(new HeroNode(6, "name5", "nick5"));
        singleLinkedList.delete(3);
        singleLinkedList.list();
    }

}

// 定义SingleLinkedList管理英雄排名
class SingleLinkedList {
    // 初始化一个头节点，头节点不存放具体数据
    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 当不考虑编号顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head节点不能动，因此需要一个辅助遍历temp
        HeroNode temp = headNode;
        // 遍历链表，找到最后
        while (true) {
            if (null == temp.next) {
                break;
            }

            // 如果没有找到最后，temp后移
            temp = temp.next;
        }

        // 当推出while循环时，temp就指向了链表的最后
        // 将最后这个节点的next指向新的节点
        temp.next = heroNode;

    }

    /**
     * 根据排名插入到指定位置(如果有这个排名，则添加失败，并给出提示)
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，因此通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为是单链表，查找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = headNode;
        boolean flag = false; // 添加的排名编号是否存在
        while (true) {
            if (null == temp.next) { // temp已经在链表的最后
                break;
            }

            if (temp.next.heroNo > heroNode.heroNo) { // 位置找到，就在temp后面插入
                break;
            } else if (temp.next.heroNo == heroNode.heroNo) { // 希望添加的heroNode的排名编号已存在
                flag = true; // 说明编号存在
                break;
            }

            temp = temp.next; // 后移，遍历当前链表

        }

        if (flag) { // 排名编号已存在，不能添加
            System.out.printf("准备插入的英雄编号%d已存在，不能加入\n", heroNode.heroNo);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据heroNo编号来修改节点信息(heroNo编号不能更改)
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }

        // 根据heroNo编号找到需要修改的节点
        HeroNode temp = headNode.next; // 定义辅助变量
        boolean flag = false; // 表示是否找到该节点

        while (true) {
            if (null == temp) { // temp已在链表尾
                break;
            }

            if (temp.heroNo == newHeroNode.heroNo) {
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("不存在编号为%d的节点\n", newHeroNode.heroNo);
        }
    }

    /**
     * 根据排名编号heroNo删除节点信息
     * 1.头节点head不能动，需要一个辅助节点temp定位待删除节点的前一个节点
     * 2.比较时，是temp.next.no和需要删除节点的heroNo比较
     * @param deleteHeroNo
     */
    public void delete(int deleteHeroNo) {
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode;
        boolean flag = false;

        while(true) {
            if (null == temp.next) { // temp是链表最后一个节点
                break;
            }

            if (temp.next.heroNo == deleteHeroNo) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("不存在编号为%d节点\n", deleteHeroNo);
        }

    }

    /**
     * 遍历链表
     */
    public void list() {
        // 判断链表是否为空
        if (null == headNode.next) {
            System.out.println("链表为空");
            return;
        }

        // 因为头节点，不能动，因此我们需要一个辅助变量
        HeroNode temp = headNode.next;
        while (true) {
            // 判断是否到链表尾
            if (null == temp) {
                break;
            }

            // 输出节点信息
            System.out.println(temp);

            // 将temp后移
            temp = temp.next;
        }
    }

}

// 每个HeroNode对象就是一个节点
class HeroNode {
    public int heroNo;
    public String name;
    public String nickName;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int heroNo, String name, String nickName) {
        this.heroNo = heroNo;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "heroNo=" + heroNo +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
