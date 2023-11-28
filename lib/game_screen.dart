import 'package:flutter/material.dart';
//import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';

class GameScreen extends StatelessWidget {
  final int selectedLevel;

  GameScreen({required this.selectedLevel});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Crossword Game - Level $selectedLevel'),
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
    List<List<String>> crosswordGrid = [
      ['c', 'o', 'm', 'p', 'u', 't', 'e', 'r'],
      ['o', '', '', '', '', '', '', '', ''],
      ['m', '', '', '', '', '', '', '', ''],
      ['p', '', '', '', '', '', '', '', ''],
      ['u', '', '', '', '', '', '', '', ''],
      ['t', '', '', '', '', '', '', '', ''],
      ['e', '', '', '', '', '', '', '', ''],
      ['r', '', '', '', '', '', '', '', ''],
      // Add more rows as needed
    ];

    return Column(
      children: [
        for (int i = 0; i < crosswordGrid.length; i++)
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              for (int j = 0; j < crosswordGrid[i].length; j++)
                Container(
                  width: 40.0,
                  height: 40.0,
                  margin: EdgeInsets.all(2.0),
                  child: TextField(
                    textAlign: TextAlign.center,
                    decoration: InputDecoration(
                      border: OutlineInputBorder(),
                      contentPadding: EdgeInsets.all(10.0),
                    ),
                    readOnly: crosswordGrid[i][j] == '',
                    controller: TextEditingController(
                      text: crosswordGrid[i][j],
                    ),
                  ),
                ),
            ],
          ),
      ],
    );
  }

  Widget buildHintsSection() {
    List<String> hints = [
      'Across: 1. Electronic device',
      'Down: 2. Study of the natural world',
    ];

    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          'Hints:',
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
}