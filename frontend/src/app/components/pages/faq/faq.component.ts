import { Component, OnInit } from '@angular/core';



@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.less']
})
export class FaqComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

 
  
}

export class Question
{
 public Q:String;
 public A:String;
};

export class Questions
{

}
