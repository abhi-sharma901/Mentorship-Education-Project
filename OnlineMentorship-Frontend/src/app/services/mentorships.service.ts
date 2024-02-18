import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl =['http://localhost:8091/onlineMentorship/guest'];
@Injectable({
  providedIn: 'root'
})
export class MentorshipsService {

  constructor(private http: HttpClient) { }

  getAllMentorships(): Observable<any> {
    return this.http.get(baseUrl + "/viewMentorships");
  }
  setCurrentMentorship(mentorship:any){
    console.log(mentorship)
    localStorage.setItem('mentorship',JSON.stringify(mentorship));
  }
  getCurrentMentorshipId(){
    let s =localStorage.getItem("mentorship");
    if(s!= null) {
      let mentorship = JSON.parse(s);
      return mentorship.mentorshipId;
    }
    return null;
    // return localStorage.getItem('courseId');
  }
  getCurrentMentorshipCost(){
    let s =localStorage.getItem("mentorship");
    if(s!= null) {
      let mentorship = JSON.parse(s);
      return mentorship.mentorshipCost
    }
    return null;
  }
  getCurrentMentorshipName(){
    let s =localStorage.getItem("mentorship");
    if(s!= null) {
      let mentorship = JSON.parse(s);
      return mentorship.mentorshipName
    }
    return null;
  }
}


