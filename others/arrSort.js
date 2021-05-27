1、 冒泡排序
原理： 数组相邻两项进行比较， 如果前一项比后一项大则交换位置， 比较arr.length - 1 轮, 每一轮把最大的一位数放最后
var arr = [2, 88, 6, 8, 3, 0, 34, 72];
var sort = {};
sort.bubbleSort = function(arr) {
  if (arr.length <= 1) {
    return arr;
  }
  //i表示比较的轮数
  for (var i = 0; i < arr.length - 1; i++) {
    //比较i轮，把i个最大数放在数组后面，排数这i个数
    for (var j = 0; j < arr.length - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        var temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
    console.log("第" + i + "轮:arr=[" + arr + "]");
  }
};
sort.bubbleSort(arr);
console.log(arr);
第0轮: arr = [2, 6, 8, 3, 0, 34, 72, 88]
第1轮: arr = [2, 6, 3, 0, 8, 34, 72, 88]
第2轮: arr = [2, 3, 0, 6, 8, 34, 72, 88]
第3轮: arr = [2, 0, 3, 6, 8, 34, 72, 88]
第4轮: arr = [0, 2, 3, 6, 8, 34, 72, 88]
第5轮: arr = [0, 2, 3, 6, 8, 34, 72, 88]
第6轮: arr = [0, 2, 3, 6, 8, 34, 72, 88]
  [0, 2, 3, 6, 8, 34, 72, 88]
2、 快速排序
原理: 通过一趟排序将要排序的数据分割成独立的两部分, 其中一部分的所有数据都比另外一部分的所有数据都要小，
然后再按此方法对这两部分数据分别进行快速排序， 整个排序过程可以递归进
  (1) 在数据集之中， 选择一个元素作为 "基准" (pivot)。
  (2) 所有小于 "基准"
的元素， 都移到 "基准"
的左边； 所有大于 "基准"
的元素， 都移到 "基准"
的右边。
  (3) 对 "基准"
左边和右边的两个子集， 不断重复第一步和第二步， 直到所有子集只剩下一个元素为止。
var arr = [2, 88, 6, 8, 3, 0, 34, 72];
var sort = {};
sort.quickSort = function(arr) {
  if (arr.length <= 1) {
    return arr;
  }
  var base = [arr[0]]; //选择的基准元素
  var leftSmall = [],
    rightBig = [];
  for (var i = 1; i < arr.length; i++) {
    if (arr[i] <= base[0]) {
      leftSmall.push(arr[i]);
    } else {
      rightBig.push(arr[i]);
    }
  }
  console.log("leftSmall:[" + leftSmall + "]\nbase:" + base + "\nrightBig:[" + rightBig + "]");
  return sort.quickSort(leftSmall).concat(base, sort.quickSort(rightBig));
}
console.log(sort.quickSort(arr));

leftSmall: [0]
base: 2
rightBig: [88, 6, 8, 3, 34, 72]
  [0, 2, 88, 6, 8, 3, 34, 72]

leftSmall: [6, 8, 3, 34, 72]
base: 88
rightBig: []
  [0, 2, 6, 8, 3, 34, 72, 88]

leftSmall: [3]
base: 6
rightBig: [8, 34, 72]
  [0, 2, 3, 6, 8, 34, 72, 88]

leftSmall: []
base: 8
rightBig: [34, 72]
  [0, 2, 3, 6, 8, 34, 72, 88]

leftSmall: []
base: 34
rightBig: [72]
  [0, 2, 3, 6, 8, 34, 72, 88]

[0, 2, 3, 6, 8, 34, 72, 88]
3、 选择排序
原理： 每一次从待排序的数据元素中选出最小（ 或最大） 的一个元素， 存放在序列的起始位置， 直到全部待排序的数据元素排完。
选择排序是不稳定的排序方法假定数组每次比较范围内第一个元素最小min， 和剩下的比较，
如果比假定的这个元素小， 则令min为这个元素， 直到找到最小的， 然后交换位置, 每比较一次， 就把最小的一位数找出来放数组最前面。
var arr = [2, 88, 6, 8, 3, 0, 34, 72];
var sort = {};
sort.selectionSort = function(arr) {
  for (var i = 0; i < arr.length; i++) {
    var min = arr[i]; //假定比较范围内第一个值为最小的
    var index = i; //记录最小值的下标
    for (var j = i + 1; j < arr.length; j++) {
      //找到比较范围内第一个值为最小的记录下来
      if (arr[j] < min) {
        min = arr[j];
        index = j;
      }
    }
    //把范围内最小的值交换到范围内第一个
    if (index != i) {
      var temp = arr[i];
      arr[i] = arr[index];
      arr[index] = temp;
    }
    console.log(arr + "\n");
  }
}
sort.selectionSort(arr);
console.log(arr);

0, 88, 6, 8, 3, 2, 34, 72

0, 2, 6, 8, 3, 88, 34, 72

0, 2, 3, 8, 6, 88, 34, 72

0, 2, 3, 6, 8, 88, 34, 72

0, 2, 3, 6, 8, 88, 34, 72

0, 2, 3, 6, 8, 34, 88, 72

0, 2, 3, 6, 8, 34, 72, 88

0, 2, 3, 6, 8, 34, 72, 88

  [0, 2, 3, 6, 8, 34, 72, 88]
4、 插入排序
插入算法把要排序的数组分成两部分: 第一部分包含了这个数组的所有元素， 但将最后一个元素除外（ 让数组多一个空间才有插入的位置），
而第二部分就只包含这一个元素（ 即待插入元素）。 在第一部分排序完成后， 再将这个最后元素插入到已排好序的第一部分中。
var arr = [2, 88, 6, 8, 3, 0, 34, 72];
function insertionSort(arr) {
  var len = arr.length,preIndex,cur;
  for (var i = 1; i < len; ++i) {
    preIndex = i - 1; // 上一个指针
    cur = arr[i]; // 取出当前元素
    while (preIndex >= 0 && arr[preIndex] > cur) {
      arr[preIndex + 1] = arr[preIndex]; // 将当前元素向后移动
      preIndex--; // 上一个指针减一
    }
    arr[preIndex + 1] = cur; // 将当前元素赋值给指针
  }
  return arr;
}

insertionSort(arr);

5、 希尔排序
原理: 先将整个待排元素序列分割成若干个子序列（ 由相隔某个“ 增量” 的元素组成的） 分别进行直接插入排序，
然后依次缩减增量再进行排序， 待整个序列中的元素基本有序（ 增量足够小） 时， 再对全体元素进行一次直接插入排序。
var arr = [2, 88, 6, 8, 3, 0, 34, 72],
  len = arr.length;
for (var fraction = Math.floor(len / 2); fraction > 0; fraction = Math.floor(fraction / 2)) {
  for (var i = fraction; i < len; i++) {
    for (var j = i - fraction; j >= 0 && arr[j] > arr[fraction + j]; j -= fraction) {
      var temp = arr[j];
      arr[j] = arr[fraction + j];
      arr[fraction + j] = temp;
    }
  }
}
console.log(arr);
