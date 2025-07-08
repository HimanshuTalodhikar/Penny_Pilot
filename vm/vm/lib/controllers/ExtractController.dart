import 'dart:convert';

import 'package:flutter/foundation.dart';
import 'package:http/http.dart' as http;

class ChatService {
  static String get baseUrl {
    if (kIsWeb) {
      return 'http://localhost:8080/api/chat'; // Web
    } else {
      return 'http://10.0.2.2:8080/api/chat'; // Android Emulator
    }
  }

  static Future<String> sendMessage(String message) async {
    final response = await http.post(
      Uri.parse(baseUrl),
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode(message),
    );

    if (response.statusCode == 200) {
      return response.body;
    } else {
      throw Exception('Failed to get response');
    }
  }
}