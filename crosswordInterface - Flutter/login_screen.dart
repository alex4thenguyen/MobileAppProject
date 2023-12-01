import 'package:flutter/material.dart';

import 'level_selection_screen.dart';

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  TextEditingController _usernameController = TextEditingController();
  TextEditingController _passwordController = TextEditingController();

  // Hardcoded valid credentials for demonstration
  final String validUsername = 'user123';
  final String validPassword = 'password123';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Crossword Game Login'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _usernameController,
              decoration: InputDecoration(labelText: 'Username'),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _passwordController,
              decoration: InputDecoration(labelText: 'Password'),
              obscureText: true,
            ),
            SizedBox(height: 32),
            ElevatedButton(
              onPressed: () {
                // Check if entered credentials match the hardcoded values
                if (_usernameController.text == validUsername &&
                    _passwordController.text == validPassword) {
                  // Navigate to the level selection screen on successful login
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => LevelSelectionScreen(),
                    ),
                  );
                } else {
                  // Credentials are invalid, you can show an error message
                  print('Invalid username or password');
                }
              },
              child: Text('Login'),
            ),
          ],
        ),
      ),
    );
  }
}
