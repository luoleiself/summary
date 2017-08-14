// async - await
async function timeout(ms) {
  await new Promise((resolve, reject) => {
    setTimeout(resolve, ms);
  })
}
async function asyncPrint(value, ms) {
  await timeout(ms);
  console.log(value);
}
asyncPrint('Hello World', 3000);
// Hello World 
// async - await
function getFirstName() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('Hello');
    }, 2000)
  })
}
function getLastName() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('World');
    }, 1000)
  })
}
async function say() {
  let firstName = await getFirstName();
  let lastName = await getLastName();
  return firstName + lastName;
}
(async function () {
  console.log(await say())
})();
// HelloWorld
// async - await
async function logInOrder(urls) {
  // 并发读取远程url
  const textPromises = urls.map(async url => {
    const response = await fetch(url);
    return response.text();
  })
  // 按次序输出
  for (const textPromise of textPromises) {
    console.log(await textPromise);
  }
}
