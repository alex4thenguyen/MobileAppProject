import 'package:flutter/material.dart';

import 'game_screen.dart';

class LevelSelectionScreen extends StatelessWidget {
  // Replace this list with the actual levels you want to display
  final List<int> levels = List.generate(9, (index) => index + 1);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Select Level'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              'Select a level',
              style: TextStyle(
                fontSize: 24.0,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          Expanded(
            child: GridView.builder(
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                crossAxisSpacing: 8.0,
                mainAxisSpacing: 8.0,
              ),
              itemCount: levels.length,
              padding: EdgeInsets.all(16.0),
              itemBuilder: (context, index) {
                return buildLevelButton(levels[index], context);
              },
            ),
          ),
        ],
      ),
    );
  }

  Widget buildLevelButton(int level, BuildContext context) {
    return GestureDetector(
      onTap: () {
        // Handle level selection, navigate to the game screen with the selected level
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => GameScreen(selectedLevel: level),
          ),
        );
      },
      child: Container(
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(8.0),
          boxShadow: [
            BoxShadow(
              color: Colors.grey.withOpacity(0.5),
              spreadRadius: 2,
              blurRadius: 5,
              offset: Offset(0, 3), // changes position of shadow
            ),
          ],
        ),
        child: Center(
          child: Text(
            '$level',
            style: TextStyle(
              fontSize: 24.0,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
