declare module '@apiverve/nationaldebt' {
  export interface nationaldebtOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface nationaldebtResponse {
    status: string;
    error: string | null;
    data: NationalDebtData;
    code?: number;
  }


  interface NationalDebtData {
      date:                           Date;
      totalDebt:                      number;
      totalDebtFormatted:             string;
      publicDebt:                     number;
      publicDebtFormatted:            string;
      intragovernmentalDebt:          number;
      intragovernmentalDebtFormatted: string;
      perCapita:                      number;
      perCapitaFormatted:             string;
      population:                     number;
  }

  export default class nationaldebtWrapper {
    constructor(options: nationaldebtOptions);

    execute(callback: (error: any, data: nationaldebtResponse | null) => void): Promise<nationaldebtResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: nationaldebtResponse | null) => void): Promise<nationaldebtResponse>;
    execute(query?: Record<string, any>): Promise<nationaldebtResponse>;
  }
}
