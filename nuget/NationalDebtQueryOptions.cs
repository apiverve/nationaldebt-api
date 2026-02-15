using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.NationalDebt
{
    /// <summary>
    /// Query options for the National Debt API
    /// </summary>
    public class NationalDebtQueryOptions
    {
        /// <summary>
        /// Optional date in YYYY-MM-DD format for historical lookup. Omit for current data.
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }
    }
}
