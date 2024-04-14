# How To

Record the thoughts and ideas that come to mind to fullfill this project.

## Build the developing environment

1. Install the JAVA SDK
2. Combine the JAVA SDK with the Visual Studio Code
3. Start a new project with JAVA Swing

## Build the UI

Separate with three parts:
- Menu Bar
- Button Panel
  - Select Button
  - Association Line Button
  - Composition Line Button
  - Generalization Line Button
  - Class Button (BASIC)
  - Use Case Button (BASIC)
- Canvas

- 基本物件，當今天 Class, Use Case 被選擇時，要能夠在 Canvas 上產生 Class, Use Case 物件
    1. 點完按鈕之後
    2. 在 Canvas 上點擊，並且會得到 (x, y)
    3. 在 (x, y) 建立物件
    4. 切換 Mode 也就是點擊其他的按鈕，就會結束建立物件的動作
    5. 每個物件的東南西北都會有個點可以連接
- 連結物件，當今天 Association, Composition, Generalization 被選擇時，要能夠在 Canvas 上產生連結物件，並且是可以連結 Class, Use Case 物件
    1. 點擊按鈕之後
    2. 當今天在 Canvas 點擊 class or Use case 的物件，並且滑鼠左鍵不放開
    3. 可以進行拖曳
    4. 當拖曳到其他的 Class or Use Case 物件上時，會產生連結物件，並且要根據 Arrow Type 產生不同的箭頭。