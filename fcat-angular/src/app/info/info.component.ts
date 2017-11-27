import {
  Component, OnInit, Input, Output, EventEmitter
} from '@angular/core';



@Component({
  selector: 'my-info',
  template: `
   <div style="position: absolute;z-index: 200;right:10px;" *ngIf="msgFlag">
  <div class="alert alert-success alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
    <h4><i class="icon fa fa-check"></i> {{msgLabel}}</h4>
    <div style="min-width:100px;"> {{msg}}</div>
  </div>
</div>`
})
export class InfoComponent implements OnInit {
  public msgFlag:boolean;
  @Input() public msgLabel:string = '提示！';
  public msgStr:string = '这是一个提示信息';
  public _msg:string;
  @Output() public msg_:EventEmitter<string> = new EventEmitter<string>();

  ngOnInit():void {
    this._msg = this.msgStr;
    this.msgFlag = false;
    this.msg_.emit(this._msg);
  }

  showInfo(){
    this.msgFlag = true;
    setTimeout(() => {
      this.ngOnInit();
    }, 1000);
  }

  @Input()
  public get msg():string {
    return this._msg;
  }


  public set msg(msg:string) {
      if(msg==this.msgStr){
        return;
      }
      if(!msg || msg=='')return;
      this._msg = msg;
      this.showInfo();
  }
}
