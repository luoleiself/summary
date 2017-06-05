var data = [
  { id: 1, title: 'pid=0', pid: 0 },
  { id: 2, title: 'pid=1', pid: 1 },
  { id: 3, title: 'pid=2', pid: 2 },
  { id: 4, title: 'pid=2', pid: 2 },
  { id: 5, title: 'pid=1', pid: 1 },
  { id: 6, title: 'pid=5', pid: 5 },
  { id: 7, title: 'pid=0', pid: 0 }
];
function treeRecursion(arr, pid) {
  var result = [],temp;
  for (var i = 0; i < arr.length; i++) {
    if (arr[i].pid == pid) {
      result.push(arr[i]);
      temp = treeRecursion(arr, arr[i].id);
      if (temp.length > 0) {
        arr[i].children = temp;
      }
    }
  }
  return result;
}
console.log(treeRecursion(data, 0));
