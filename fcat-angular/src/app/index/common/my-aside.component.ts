import { Component,OnInit } from '@angular/core';
import { Config } from '../../app-config';
import {TMenuService} from "../../baseinfo/t-menu.service";
import {TUserService} from "../../baseinfo/t-user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'my-aside',
  templateUrl: './my-aside.component.html'
})

export class MyAsideComponent implements OnInit{
  treeMenu:any[];
  app:any;
  selectedFirstMenuId:any;
  selectedMenuId:any;
  firstMenuId:any;
  username:string;
  selectedSystemId:any;
  menuList:any[];

  flag : boolean;

  constructor(private config:Config,
              private router:Router,
              private tMenuService:TMenuService,
              private tUserService:TUserService){
    this.app = config.appConfig;
    this.flag=false;
  }
  ngOnInit():void {
    this.selectedFirstMenuId = sessionStorage.getItem("firstMenu");
    this.selectedMenuId = sessionStorage.getItem("secondMenu");
    this.tUserService.getSessionInfo().subscribe(data =>{
      this.tUserService.setLocalSessionInfo(data.data);
      this.username = data.data.username;
      //this.getUserMenu();
      this.tUserService.getAuthorityByUsername(this.username).subscribe(data =>{
        this.treeMenu = data.data.tMenuTrees;
        this.selectMenuList();
        this.tUserService.setLocalAuthorityTElements(data.data.tElements);
      });
    });
  }
  selectFirstMenu(menu:any){
    menu.isOpen=!menu.isOpen; 
    if(menu.isOpen){
      this.selectedFirstMenuId = menu.id;
      sessionStorage.setItem("firstMenu",this.selectedFirstMenuId);
    }else{
      this.selectedFirstMenuId = null;
      sessionStorage.setItem("firstMenu",null);
    }
  }
  selectedSecondMenu(menu:any,href:any){
    this.selectedMenuId=menu.id;
    sessionStorage.setItem("secondMenu",this.selectedMenuId);
    this.router.navigate([href]);
  }
  toggle(){
    this.flag = !this.flag;
  }

  getUserMenu():void {
    this.tMenuService.getTree().subscribe(data => {
      this.treeMenu = data.data;
      this.selectMenuList();
    });
  }

  selectMenuList():void {
    if(this.treeMenu && this.treeMenu.length>0 ){
      if(!this.selectedSystemId){
        this.selectedSystemId = this.treeMenu[0].id;
      }
    }
    for(let i=0;i<this.treeMenu.length;i++){
      if(this.treeMenu[i].id==this.selectedSystemId){
        this.menuList = this.treeMenu[i].children;
        this.menuList.forEach(menu=>{ 
          if(menu.id==this.selectedFirstMenuId){
            menu.isOpen = true;
          }
        });
      }
    }
  }
}
