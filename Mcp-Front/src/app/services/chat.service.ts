import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ChatMessage {
  content: string;
  isUser: boolean;
  timestamp: Date;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  private apiUrl = 'http://localhost:8066';

  constructor(private http: HttpClient) { }

  sendMessage(message: string): Observable<string> {
    let params = new HttpParams()
      .set('query', message);
    
    return this.http.post(`${this.apiUrl}/chat`, null, {
      responseType: 'text',
      params: params
    });
  }
}