import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../service/';
import { MenuItem } from 'primeng/components/common/menuitem';
import {DataListModule} from 'primeng/primeng';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {
  user: String;
  
  pets: Pets[];
  selectedPets: Pets;
  items: MenuItem[];
 // limtems: ;




  constructor(private apiService: ApiService) { }

  ngOnInit() {
    // this.apiService.get('api/user/').subscribe(res => {
    //    this.user = JSON.stringify(res);
    // });

    this.apiService.get('api/pets/').subscribe(res => {
      this.pets = res;
    });


    this.items = [
      { label: 'View', icon: 'fa-search', command: (event) => this.viewPets(this.selectedPets) },
      { label: 'Delete', icon: 'fa-close', command: (event) => this.deletePets(this.selectedPets) }
    ];


  }
  viewPets(select: Pets) {
    console.log(JSON.stringify(select));

  }
  deletePets(select: Pets) {
    this.apiService.delete('api/pets/' + select.id).subscribe(res => {
      console.log(res);
    });

  }


  }



interface Pets {
  id: number;
  Name: String;
  Type: String;
  ImageName: String;
 }
