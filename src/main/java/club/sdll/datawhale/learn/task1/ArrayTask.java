package club.sdll.datawhale.learn.task1;

import java.util.Arrays;

/**
 * @author shandianlala@gmail.com
 * @description 实现一个支持动态扩容的数组 Dynamic expansion
 * 实现一个大小固定的有序数组，支持动态增删改操作
 * 实现两个有序数组合并为一个有序数组
 * 学习哈希表思想，并完成leetcode上的两数之和(1)及Happy Number(202)！(要求全部用哈希思想实现！)（选做）（注意：在第四天会进行继续学习）
 * @since 2019-08-04 18:04
 */
public class ArrayTask {

    public static void main(String[] args) {
        // test dynamicExpansionArray
        DynamicExpansionArray<String> dynamicExpansionArray = new DynamicExpansionArray<String>();
        System.out.println("the initialSize is " + dynamicExpansionArray.size());
        dynamicExpansionArray.add("zhangsan");
        System.out.println("after first invoke the method add(), the new size is " + dynamicExpansionArray.size());
        dynamicExpansionArray.add("lisi");
        System.out.println("after second invoke the method add(), the new size is " + dynamicExpansionArray.size());
        int size = dynamicExpansionArray.size();
        for (int i = 0; i < size; i++) {
            System.out.println("the index " + i + ", the value is " + dynamicExpansionArray.get(i));
        }
        System.out.println("===================separator=====================");
        // test 实现两个有序数组合并为一个有序数组
        int[] a = {1, 3, 4, 6, 12, 45, 46, 50};
        int[] b = {2, 7, 11, 15, 47, 51};
        int[] mergedArray = mergeArray(a, b);
        int mergedArraySize = mergedArray.length;
        for (int i = 0; i < mergedArraySize; i++) {
            System.out.println("the index " + i + ", the value is " + mergedArray[i]);
        }

    }

    public static int[] mergeArray(int a[], int b[]) {
        int mergedArray[] = new int[a.length + b.length];
        int ai = 0, bj = 0, mk = 0;
        while (ai < a.length && bj < b.length) {
            if (ai == a.length -1) {
                mergedArray[mk++] = b[bj++];
            } else if (bj == b.length -1) {
                mergedArray[mk++] = a[ai++];
            } else {
                if (a[ai] <= b[bj]) {
                    mergedArray[mk++] = a[ai++];
                } else {
                    mergedArray[mk++] = b[bj++];
                }
            }
        }
        return mergedArray;
    }

}

/**
 * 动态扩容的数组实现,每次实现数组size加1.
 *
 * @param <E>
 */
class DynamicExpansionArray<E> {
    private Object[] elementData;

    private int size;

    private final int DEFAULT_LENGTH = 10;

    private final Object[] EMPTY_ELEMENT_DATA = {};

    public DynamicExpansionArray() {
        elementData = EMPTY_ELEMENT_DATA;
    }

    public DynamicExpansionArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illeagal argument size, it must be positive number, pleage check it!");
        }
        this.size = size;
        elementData = new Object[size];
    }

    public boolean add(E e) {
        ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    public E get(int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Illeagal argument index,  pleage check it!");
        }
        return (E) elementData[index];
    }

    private void ensureCapacity() {
        Object[] tempElementData = elementData;
        int oldLength = tempElementData.length;
        if (oldLength == size) {
            int newSize = size + 1;
            elementData = Arrays.copyOf(elementData, newSize, Object[].class);
        }
    }

    public int size() {
        return size;
    }

}


/**
 * 实现一个大小固定的有序数组，支持动态增add删remove改set操作
 *
 * @param <E>
 */
class FixedOrderedArray<E> {
    private Object[] elementData;

    private int size;

    private final int DEFAULT_LENGTH = 10;

    private final Object[] EMPTY_ELEMENT_DATA = {};

    public FixedOrderedArray() {
        elementData = EMPTY_ELEMENT_DATA;
    }

    public FixedOrderedArray(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illeagal argument size, it must be positive number, pleage check it!");
        }
        this.size = size;
        elementData = new Object[size];
    }

    public boolean add(E e) {
        ensureCapacity();
        elementData[size++] = e;
        return true;
    }

    public E remove(int index) {
        checkIndex(index);
        Object[] tempElementData = elementData;
        E oldValue = (E) tempElementData[index];
        int numMoved = size - 1 - index;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    public boolean set(int index, E e) {
        checkIndex(index);
        elementData[index] = e;
        return true;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    private void ensureCapacity() {
        Object[] tempElementData = elementData;
        int oldLength = tempElementData.length;
        if (oldLength == size) {
            int newSize = size + 1;
            elementData = Arrays.copyOf(elementData, newSize, Object[].class);
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Illeagal argument index,  pleage check it!");
        }
    }

    public int size() {
        return size;
    }
}

