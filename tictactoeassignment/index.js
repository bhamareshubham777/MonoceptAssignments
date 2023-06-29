const Game = require("./game");
let symbol1 = "X";
let symbol2 = "O";
try {
    //game play 1
    let game1 = Game.addGame("Shubham", symbol1, "Rushi", symbol2);
    console.log(game1.play(0));
    console.log(game1.play(0));ṇ
    console.log(game1.play(4));
    console.log(game1.play(8));
    console.log(game1.play(2));
    console.log(game1.play(6));
    console.log(game1.play(7));
    console.log(game1.play(3)); //game over
    console.log(game1.play(1));

    //game play 2
    let game2 = Game.addGame("Pavan", symbol2, "Pranit", symbol1);
    console.log(game2.play(0));
    console.log(game2.play(0));
    console.log(game2.play(4));
    console.log(game2.play(8));
    console.log(game2.play(2));
    console.log(game2.play(6));
    console.log(game2.play(7));
    console.log(game2.play(3)); //game over
    console.log(game2.play(1));

} catch (error) {
    console.log(error.message);
}
