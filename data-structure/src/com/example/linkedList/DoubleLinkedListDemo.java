package com.example.linkedList;

public class DoubleLinkedListDemo {
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

        // 当推出while循环时，temp就指向了链表的最后
        // 形成了一个双向链表
        temp.next = heroNode2;
        heroNode2.pre = temp;
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
