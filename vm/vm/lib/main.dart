import 'package:flutter/material.dart';
import 'package:vm/pages/Start_Page.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Finance AI Chat',
      theme: ThemeData(primarySwatch: Colors.teal),
      home: const ChatScreen(),
    );
  }
}