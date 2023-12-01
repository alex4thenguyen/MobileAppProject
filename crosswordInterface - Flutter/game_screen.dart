import 'package:flutter/material.dart';

class GameScreen extends StatefulWidget {
  final int selectedLevel;

  GameScreen({required this.selectedLevel});

  @override
  _GameScreenState createState() => _GameScreenState();
}

class _GameScreenState extends State<GameScreen> {
  final List<List<String>> crosswordGrid = [
    ['', '', '', '', '', '', 'd', '', ''],
    ['s', 'c', 'i', 'e', 'n', 'c', 'e', '', ''],
    ['', '', '', '', '', '', 'v', '', ''],
    ['c', 'o', 'm', 'p', 'u', 't', 'e', 'r', ''],
    ['', '', '', 'l', '', '', 'l', '', ''],
    ['', '', '', 'a', '', 'l', 'o', 'g', ''],
    ['', '', '', 'n', '', '', 'p', '', ''],
    ['', '', '', '', '', '', '', '', ''],
    // Add more rows as needed
  ];

  final Map<String, String> correctAnswers = {
    'Across1': 'computer',
    'Across2': 'SCIENCE',
    'Across3': 'log',
    'Down1': 'develop',
    'Down2': 'plan',
  };

  Map<String, String> guessedLetters = {};
  List<List<bool>> highlightedCells = [];

  @override
  void initState() {
    super.initState();

    // Initialize highlightedCells with the same dimensions as crosswordGrid
    highlightedCells = List.generate(
      crosswordGrid.length,
      (i) => List.generate(crosswordGrid[i].length, (j) => false),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Crossword Game - Level ${widget.selectedLevel}'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          SizedBox(height: 20.0),
          buildCrosswordPuzzle(),
          SizedBox(height: 20.0),
          buildHintsSection(),
        ],
      ),
    );
  }

  Widget buildCrosswordPuzzle() {
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          for (int i = 0; i < crosswordGrid.length; i++)
            Row(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                for (int j = 0; j < crosswordGrid[i].length; j++)
                  GestureDetector(
                    onTap: () => handleCellTap(i, j),
                    child: Container(
                      width: 40.0,
                      height: 40.0,
                      margin: EdgeInsets.all(2.0),
                      decoration: BoxDecoration(
                        color: highlightedCells[i][j] ? Colors.green : null,
                        border: crosswordGrid[i][j].isNotEmpty
                            ? Border.all(color: Colors.black)
                            : null,
                        borderRadius: BorderRadius.circular(8.0),
                        boxShadow: [
                          if (crosswordGrid[i][j].isNotEmpty)
                            BoxShadow(
                              color: Colors.grey.withOpacity(0.5),
                              spreadRadius: 2,
                              blurRadius: 5,
                              offset: Offset(0, 3),
                            ),
                        ],
                      ),
                      child: TextField(
                        textAlign: TextAlign.center,
                        decoration: InputDecoration(
                          border: InputBorder.none,
                          contentPadding: EdgeInsets.all(10.0),
                        ),
                        readOnly: crosswordGrid[i][j].isEmpty,
                        controller: TextEditingController(
                          text: guessedLetters['$i-$j'] ??
                              (crosswordGrid[i][j].isNotEmpty
                                  ? ''
                                  : null), // Display guessed letters if available
                        ),
                        onChanged: (input) {
                          // Check if the entered word is correct
                          checkAnswer(i, j, input);
                        },
                      ),
                    ),
                  ),
                SizedBox(width: 2.0),
              ],
            ),
        ],
      ),
    );
  }

  Widget buildHintsSection() {
    List<String> hints = [
      'Across:',
      '1. Electronic device',
      '2. Study of the natural world',
      '3. A record of things',
      'Down:',
      '1. Process of creating an app',
      '2. To schedule',
    ];

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          'Hints',
          style: TextStyle(
            fontSize: 18.0,
            fontWeight: FontWeight.bold,
          ),
        ),
        SizedBox(height: 8.0),
        for (int i = 0; i < hints.length; i++)
          Padding(
            padding: EdgeInsets.symmetric(vertical: 4.0),
            child: Text(
              hints[i],
              style: TextStyle(fontSize: 16.0),
            ),
          ),
      ],
    );
  }

  void checkAnswer(int rowIndex, int colIndex, String input) {
    String key = (rowIndex + 1).toString();
    String answerKey = 'Across$key';
    if (correctAnswers.containsKey(answerKey)) {
      String correctAnswer = correctAnswers[answerKey]!;
      if (correctAnswer.length > colIndex &&
          correctAnswer[colIndex] == input.toLowerCase()) {
        // If the entered letter matches the correct answer
        setState(() {
          guessedLetters['$rowIndex-$colIndex'] = input.toUpperCase();
        });

        // Check if the entire word is guessed and highlight the cells
        bool wordGuessed = true;
        for (int k = 0; k < correctAnswer.length; k++) {
          if (guessedLetters['$rowIndex-${colIndex + k}'] !=
              correctAnswer[k].toUpperCase()) {
            wordGuessed = false;
            break;
          }
        }

        if (wordGuessed) {
          setState(() {
            for (int k = 0; k < correctAnswer.length; k++) {
              highlightedCells[rowIndex][colIndex + k] = true;
            }
          });
        }
      }
    }
  }

  void handleCellTap(int rowIndex, int colIndex) {
    // Handle cell tap if needed
  }
}